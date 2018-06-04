import React, {Component} from 'react'
import {connect} from 'react-redux'
import styles from './style.less'
import {Input, Button,notification} from 'antd'
import $ from 'jquery'
import * as actions from 'actions/chat'
var clientIp=window.clientIp

class Chat extends Component {
    constructor(props) {
        super(props)
        this.state={
            ws:null
        }
    }

    componentDidMount(){
        const host=window.location.host//主机名加端口号
        let ws = new WebSocket(`ws://${host}/websocket`)
        const _this=this
        this.setState({ws})
        ws.onopen = function () {
            ws.send("webSocket服务已开启");
        }
        ws.onmessage = function (event) {
            const message = event.data
            // console.log("来自服务气的消息",message)
            $('#div1').append(message+'<br/>')
        }

        ws.onerror = function (evt) {
            ws.close()
            console.log('websocket error', evt)
        }
        ws.onclose = function (evt) {
            ws.close()
            console.log('websocket is closed', evt)
        }
        $(document).keydown(function (event) {
            var e = event || window.event || arguments.callee.caller.arguments[0];
            if (e && e.keyCode == 13) {
                _this.send()
            }
        })
    }

    send(){
        const message=$('input')[0].value
        if(message){
            const{ws}=this.state
            ws.send('来自'+clientIp+':'+message)
            const input=$('input')
            input[0].value=''
            input.focus()
            return
        }
        notification.error({
            message:'发送消息',
            description:'不能发送空消息',
            duration:1
        })
    }

    render() {
        return (
            <div className={styles.chat}>
                <div id="div1" className={styles.windowDiv}/>
                <Input className={styles.inputDiv}/>
                <div className={styles.buttonContainer}>
                    <Button onClick={this.send.bind(this)}>发送</Button>
                </div>
            </div>
        )
    }
}

function select(state) {
    return state.chat
}

export default connect(select)(Chat)
