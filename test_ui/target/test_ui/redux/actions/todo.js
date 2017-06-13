import $ from 'jquery'
import { notification } from 'antd';

$.postJSON = function(url, data, callback) {
    return $.ajax({
        'type' : 'POST',
        'url' : url,
        'contentType' : 'application/json',
        'data' : JSON.stringify(data),
        'dataType' : 'json',
        'success' : callback
    });
};
export function titleChange(title) {
    return {type: 'todo.titleChange', title}
}

export function addTodo() {
    return async function (dispatch,getState) {
        await $.postJSON('http://localhost:8080/newTodo',{title:getState().todo.title},function (param) {
            if(param.status==='1'){
                notification.success({
                    message:'添加任务',
                    description:'添加任务成功',
                    duration:1
                })
            }
            else{
                notification.error({
                    message:'添加任务',
                    description:param.tips,
                    duration:1
                })
            }
        })
        await extractFunction(dispatch,true)
    }
}

export function complete(parameter) {
    return async function (dispatch) {
       await $.postJSON('http://localhost:8080/changeState',parameter,function (param) {
            if(param.status==='1'){
                notification.success({
                    message:'任务执行',
                    description:'状态更改成功',
                    duration:1
                })
            }
            else{
                notification.error({
                    message:'任务执行',
                    description:param.tips,
                    duration:1
                })
            }
        })
       await extractFunction(dispatch)
    }
}

export function deleteTask(parameter) {
    return async function (dispatch) {
        await $.postJSON('http://localhost:8080/killTodo',parameter,function (param) {
            if(param.status==='1'){
                notification.success({
                    message:'删除任务',
                    description:'删除任务成功',
                    duration:1
                })
            }
            else{
                notification.error({
                    message:'删除任务',
                    description:param.tips,
                    duration:1
                })
            }
        })
        await extractFunction(dispatch)
    }
}

export function changeFilter(filter) {
    return {type: 'todo.changeFilter', filter}
}

export function getTodoList(){
    return async function (dispatch) {
        extractFunction(dispatch)
    }
}
function extractFunction(dispatch,flag){
    $.post('http://localhost:8080/todoList',{},function (param) {
        if(param.status==='1'){
            dispatch({
                type:'todo.TodoList',
                todoList:param.data
            })
            if(flag)
                dispatch({type:'todo.addTodo',title:''})
        }
    },'json')
}