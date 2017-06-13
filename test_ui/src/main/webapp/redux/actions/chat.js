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
    }
}
