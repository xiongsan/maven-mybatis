import {combineReducers} from 'redux'
import {routerReducer} from 'react-router-redux'
import todo from 'reducers/todo'
import chat from 'reducers/chat'
export default combineReducers({
    routing: routerReducer, todo,chat
})
