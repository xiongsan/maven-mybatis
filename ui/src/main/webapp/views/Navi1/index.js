import React, {Component} from 'react'
import $ from 'jquery'
class Test extends Component {
    constructor(props) {
        super(props)
        this.state = {
            newItem:'',
            items:[]
        }
    }
    componentDidMount() {

    }
    render() {
        return (
            <section id="platform-appList">

            </section>
        )
    }
}
export default Test