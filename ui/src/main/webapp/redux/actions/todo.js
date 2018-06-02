export function textChange(text) {
    return {type: 'todo.textChange', text}
}

export function addTodo() {
    return {type: 'todo.addTodo'}
}

export function complete(id) {
    return {type: 'todo.complete', id}
}

export function changeFilter(filter) {
    return {type: 'todo.changeFilter', filter}
}