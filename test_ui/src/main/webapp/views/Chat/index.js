import React, {Component} from 'react'
import {connect} from 'react-redux'
import styles from './style.less'
import {Input, Button,Progress, Checkbox, Radio,Modal} from 'antd'
import $ from 'jquery'
import * as actions from 'actions/chat'

class Chat extends Component {
    constructor(props) {
        super(props)
        this.state={
            ws:null
        }
    }

    componentDidMount(){
        const host=window.location.host//主机名加端口号
        const pathName=window.location.pathname//容器名
        const result=host+pathName
        let ws = new WebSocket('ws://localhost:8080/websocket')
        this.setState({ws})
        ws.onopen = function () {
            ws.send("webSocket服务已开启");
        }
        ws.onmessage = function (event) {
            const message = event.data
            console.log("来自服务气的消息",message)
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
    }

    send(){
        const message=$('input')[0].value
        const{ws}=this.state
        ws.send(message)
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
