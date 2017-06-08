import React, {Component} from 'react'
import {connect} from 'react-redux'
import styles from './style.less'
import {Input, Button,Progress, Checkbox, Radio} from 'antd'
import * as actions from 'actions/todo'

const RadioButton = Radio.Button
const RadioGroup = Radio.Group

class Todo extends Component {
    constructor(props) {
        super(props)
    }
    buttonClick(){
        const {dispatch}=this.props
        dispatch(actions.addTodo())
    }
    keyDown(e){
        const {text,dispatch}=this.props
        if(e.keyCode===13&&text){
            dispatch(actions.addTodo())
        }
    }

    render() {
        const {todoList, text, percent, filter,dispatch} = this.props
        return (
            <div className={styles.todo}>
                <h1>TodoApp</h1>
                <div className={styles.bar}>
                    <Input className={styles.input} value={text}
                           onChange={(e)=>dispatch(actions.textChange(e.target.value))}
                           onKeyDown={this.keyDown.bind(this)}
                    />
                    <Button type="primary" icon="plus" onClick={this.buttonClick.bind(this)}>添加</Button>
                    <Progress percent={percent} className={styles.progress}/>
                    <RadioGroup onChange={(e)=>dispatch(actions.changeFilter(e.target.value))} defaultValue="all"
                                value={filter}
                                className={styles.filter}>
                        <RadioButton value="all">全部</RadioButton>
                        <RadioButton value="finished">已完成</RadioButton>
                        <RadioButton value="unfinished">未完成</RadioButton>
                    </RadioGroup>
                </div>
                <ul className={styles.todolist}>
                    {todoList.map(todo=> {
                        return (
                            <li key={todo.id}>
                                <Checkbox checked={todo.completed}
                                          onChange={()=>dispatch(actions.complete(todo.id))}>{todo.text}</Checkbox>
                            </li>
                        )
                    })}
                </ul>
            </div>
        )
    }
}

function select(state) {
    let {todoList, filter} = state.todo
    let finishedCount = 0
    let total = todoList.length
    todoList = todoList.filter(todo=> {
        if (todo.completed === true) {
            finishedCount++
        }
        switch (filter) {
            case 'all':
                return true
            case 'finished':
                return todo.completed === true
            case 'unfinished':
                return todo.completed === false
            default:
                return true
        }
    })

    let percent = 100
    if (total > 0) {
        percent = ((finishedCount / total) * 100).toFixed(0)
    }

    return Object.assign({}, state.todo, {todoList, percent})
}

export default connect(select)(Todo)
