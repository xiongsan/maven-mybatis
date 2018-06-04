import React, {Component} from 'react'
import styles from './style.less'
import {Layout, Menu, Icon} from 'antd';
import {Link} from 'react-router';
const {Header, Sider, Content} = Layout;


class Home extends Component {
    constructor(props) {
        super(props)
        this.state = {
            collapsed: false
        }
    }
    componentWillMount(){
        console.log(this.props.children)
    }
    toggle() {
        this.setState({
            collapsed: !this.state.collapsed,
        });
    }
    /* <Link />不需要此方法*/
    menuClick(param){
       this.props.history.push(param.key)
    }
    render() {
        return (
            <Layout className={styles.layout}>
                <Sider
                    trigger={null}
                    collapsible
                    collapsed={this.state.collapsed}
                >
                    <div className="logo"/>
                    <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']} onClick={this.menuClick.bind(this)}>
                        <Menu.Item key="/navi1">
                            <Icon type="user"/>
                            <span className="nav-text">nav 1</span>
                        </Menu.Item>
                        <Menu.Item key="2">
                            <Icon type="video-camera"/>
                            <span className="nav-text">nav 2</span>
                            <Link to="/navi2" />
                        </Menu.Item>
                        <Menu.Item key="3">
                            <Icon type="upload"/>
                            <span className="nav-text">nav 3</span>
                            <Link to="/navi3" />
                        </Menu.Item>
                    </Menu>
                </Sider>
                <Layout>
                    <Header style={{background: '#fff', padding: 0}}>
                        <Icon
                            className="trigger"
                            type={this.state.collapsed ? 'menu-unfold' : 'menu-fold'}
                            onClick={this.toggle.bind(this)}
                        />
                    </Header>
                    <Content style={{margin: '24px 16px', padding: 24, background: '#fff', minHeight: 280}}>
                        {this.props.children}
                    </Content>
                </Layout>
            </Layout>
        )
    }
}
export default Home
