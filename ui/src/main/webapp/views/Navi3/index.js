import React, {Component} from 'react'
import styles from './style.less'
import {Table} from 'antd'

class Index extends Component {
    constructor(props) {
        super(props)
        this.state={
            dataSource:[{id:1,name:'zhangsan0',age:'20'},{id:2,name:'zhangsan1',age:'30'},{id:3,name:'zhangsan2',age:'40'}],
            columns:[{title:'编号',dataIndex:'id'},{title:'姓名',dataIndex:'name'},{title:'年龄',dataIndex:'age'}]
        }
    }

    render() {
        return (
            <div className={styles.container}>
            <Table dataSource={this.state.dataSource} columns={this.state.columns}/>
            </div>
        )
    }
}

export default Index
