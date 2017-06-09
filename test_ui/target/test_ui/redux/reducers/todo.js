import merge from 'common/merge'
const initialState = {
    todoList: [],
    text: '',
    filter: 'all'
}

export default function todo(state = initialState, action) {
    switch (action.type) {
        case 'todo.textChange':
            return merge(state, {text: action.text})
        case 'todo.addTodo':
            return addTodo(state, action)
        case 'todo.complete':
            return complete(state, action)
        case 'todo.changeFilter':
            return merge(state, {filter: action.filter})
        default:
            return state
    }
}

function addTodo(state, action) {
    const {todoList, text} = state
    todoList.push({id: todoList.length, text, completed: false})
    return merge(state, {todoList, text: ''})
}

function complete(state, action) {
    const {todoList} = state
    let list = todoList.map(todo=> {
        if (todo.id === action.id) {
            todo.completed = !todo.completed
        }
        return todo
    })
    return merge(state, {todoList: list})
}