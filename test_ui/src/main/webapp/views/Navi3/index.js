import React, {Component} from 'react'
import styles from './style.less'

class Index extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div className={styles.container}>
                <div className={styles.element1}/>
                <div className={styles.element2}/>
            </div>
        )
    }
}

export default Index
