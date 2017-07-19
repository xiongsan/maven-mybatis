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
import layout from '../layout/index'
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
<<<<<<< HEAD
                    <Route path="/layout" component={layout}>
                        <Route path="/navi1" component={views.Navi1}/>
                        <Route path="/navi2" component={views.Navi2}/>
                        <Route path="/navi3" component={views.Navi3}/>
                    </Route>
=======
                    <Route path="/chat" component={views.Chat}/>
>>>>>>> c2f28e066b9ce3ce4dff27766ad0e805b8a329e4
                </Router>
            </Provider>
        )
    }
}

render(<App/>, document.getElementById('app'))