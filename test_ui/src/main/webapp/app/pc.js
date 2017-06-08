import React, {Component} from 'react'
import {render} from 'react-dom'
import {Provider} from 'react-redux'
import {Router, Route, hashHistory} from 'react-router'
import {syncHistoryWithStore, routerReducer} from 'react-router-redux'
import thunk from 'redux-thunk'
import {applyMiddleware, createStore} from 'redux'
import '!style!css!less!../style/index.less'
import rootReducer from '../redux/rootReducer'
import views from '../views'
import createLogger from 'redux-logger'
const logger = createLogger()

const store = createStore(rootReducer, applyMiddleware(thunk,logger))
const history = syncHistoryWithStore(hashHistory, store)

class App extends Component {
    render() {
        return (
            <Provider store={store}>
                <Router history={history}>
                    <Route path="/" component={views.Todo}/>
                </Router>
            </Provider>
        )
    }
}

render(<App/>, document.getElementById('app'))