package bean;

import org.hyperic.sigar.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/3/21
 * Time :9:54
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class Test2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        try {
            // cpu信息
            System.out.println("cpu使用率="+cpu());
            System.out.println("内存使用率="+memory());
            System.out.println("磁盘使用率="+file());
//            cpu();
//            System.out.println("----------------------------------");
//            // 内存信息
//            memory();
//            System.out.println("----------------------------------");
//            // 文件系统信息
//            file();
//            System.out.println("----------------------------------");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }


    private static double memory() throws SigarException {
        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        // 内存总量
//        System.out.println("内存总量:    " + mem.getTotal() / 1024L + "K av");
//        // 当前内存使用量
//        System.out.println("当前内存使用量:    " + mem.getUsed() / 1024L + "K used");
//        // 当前内存剩余量
//        System.out.println("当前内存剩余量:    " + mem.getFree() / 1024L + "K free");
        return Math.round(mem.getUsed()*100 / mem.getTotal());
    }

    private static String cpu() throws SigarException {
        Sigar sigar = new Sigar();
        List<String> percents = new ArrayList<>();
        CpuInfo infos[] = sigar.getCpuInfoList();
        CpuPerc cpuList[] = sigar.getCpuPercList();
        for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
            CpuInfo info = infos[i];
//            System.out.println("第" + (i + 1) + "块CPU信息");
//            System.out.println("CPU的总量MHz:    " + info.getMhz());// CPU的总量MHz
            percents.add(printCpuPerc(cpuList[i]));
        }
//        System.out.println("平均使用率"+average(percents));
        return average(percents);
    }

    private static String  printCpuPerc(CpuPerc cpu) {
//        System.out.println("CPU用户使用率:    " + CpuPerc.format(cpu.getUser()));// 用户使用率
//        System.out.println("CPU系统使用率:    " + CpuPerc.format(cpu.getSys()));// 系统使用率
//        System.out.println("CPU当前空闲率:    " + CpuPerc.format(cpu.getIdle()));// 当前空闲率
       // System.out.println("CPU总的使用率:    " + CpuPerc.format(cpu.getCombined()));// 总的使用率
        return CpuPerc.format(cpu.getCombined());
    }

    private static String average(List<String> percents){
        double sum=0;
        for(String percent:percents){
            percent = percent.substring(0, percent.indexOf("%"));
            sum += Double.valueOf(percent);
        }
        double average = Math.round(sum / percents.size());
        return String.valueOf(average)+"%";
    }

    private static String average(Set<Double> percents){
        double sum=0;
        for(Double percent:percents){
            sum += percent;
        }
        double average = Math.round(sum / percents.size());
        return String.valueOf(average)+"%";
    }

    private static String file() throws Exception {
        Sigar sigar = new Sigar();
        FileSystem fslist[] = sigar.getFileSystemList();
        Set<Double> percents = new HashSet<>();
        for (int i = 0; i < fslist.length; i++) {
//            System.out.println("分区的盘符名称" + i);
            FileSystem fs = fslist[i];
            // 分区的盘符名称
//            System.out.println("盘符名称:    " + fs.getDevName());
//            // 分区的盘符名称
//            System.out.println("盘符路径:    " + fs.getDirName());
//            System.out.println("盘符文件系统类型:    " + fs.getType());
            FileSystemUsage usage = null;
            usage = sigar.getFileSystemUsage(fs.getDirName());
            switch (fs.getType()) {
                case 0: // TYPE_UNKNOWN ：未知
                    break;
                case 1: // TYPE_NONE
                    break;
                case 2: // TYPE_LOCAL_DISK : 本地硬盘
                    // 文件系统总大小
                   // System.out.println(fs.getDevName() + "总大小:    " + usage.getTotal() + "KB");
                    // 文件系统剩余大小
                   // System.out.println(fs.getDevName() + "剩余大小:    " + usage.getFree() + "KB");
                    // 文件系统可用大小
                   // System.out.println(fs.getDevName() + "可用大小:    " + usage.getAvail() + "KB");
                    // 文件系统已经使用量
                   // System.out.println(fs.getDevName() + "已经使用量:    " + usage.getUsed() + "KB");
                    double usePercent = usage.getUsePercent() * 100D;
                    // 文件系统资源的利用率
                   // System.out.println(fs.getDevName() + "资源的利用率:    " + usePercent + "%");
                    percents.add(usePercent);
                    break;
                case 3:// TYPE_NETWORK ：网络
                    break;
                case 4:// TYPE_RAM_DISK ：闪存
                    break;
                case 5:// TYPE_CDROM ：光驱
                    break;
                case 6:// TYPE_SWAP ：页面交换
                    break;
            }
        }
        return average(percents);
    }



}
