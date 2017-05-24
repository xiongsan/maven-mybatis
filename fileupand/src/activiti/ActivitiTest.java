package activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Wanghairui on 2017/5/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:controller-servlet.xml")
public class ActivitiTest {

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Autowired
    HistoryService historyService;
    @Test
    public void test(){
        // 部署流程定义
        repositoryService.createDeployment().addClasspathResource("bpmn20.xml").deploy();
        // 启动流程实例
        String procId = runtimeService.startProcessInstanceByKey("financialReport").getId();


        // 获得第一个任务
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("sales").list();
        for (Task task : tasks) {
            System.out.println("Following task is available for sales group: " + task.getName());
            // 认领任务这里由foozie认领，因为fozzie是sales组的成员
            taskService.claim(task.getId(), "fozzie");
        }


        // 查看fozzie现在是否能够获取到该任务
        tasks = taskService.createTaskQuery().taskAssignee("fozzie").list();
        for (Task task : tasks) {
            System.out.println("Task for fozzie: " + task.getName());
            // 执行(完成)任务
            taskService.complete(task.getId());
        }

        // 现在fozzie的可执行任务数就为0了
        System.out.println("Number of tasks for fozzie: "
                + taskService.createTaskQuery().taskAssignee("fozzie").count());





        // 获得第二个任务
        tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
        for (Task task : tasks) {
            System.out.println("Following task is available for accountancy group:" + task.getName());
            // 认领任务这里由kermit认领，因为kermit是management组的成员
            taskService.claim(task.getId(), "kermit");
        }
        // 完成第二个任务结束流程
        for (Task task : tasks) {
            taskService.complete(task.getId());
        }

        //获得第三个任务
        tasks = taskService.createTaskQuery().taskCandidateGroup("president").list();
        for(Task task :tasks){
            System.out.println("Following task is available for president group"+task.getName());
            //认领任务这里由HaiRui认领，因为HaiRui是president组的成员
            taskService.claim(task.getId(),"HaiRui");
        }
        for(Task task:tasks){
            taskService.complete(task.getId());
        }



        // 核实流程是否结束,输出流程结束时间
        HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery()
                .processInstanceId(procId).singleResult();


        System.out.println("Process instance end time: " + historicProcessInstance.getEndTime());
    }
}
