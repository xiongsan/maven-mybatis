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
        let {newItem,items}=this.state
        const _this=this
        function addData(){
            newItem=new Date().getSeconds()
            items.unshift(newItem)
            if(items.length>4){
                items.pop()
            }
            _this.setState({newItem})
            $('#div0').addClass('changePosition')
            $('#div1').addClass('changePosition')
            $('#div2').addClass('changePosition')
            $('#div3').addClass('changePosition')
            $('#div4').addClass('changePosition')
            $('#div5').addClass('changePosition')
            setTimeout(sureClass, 2000)
        }
        function sureClass() {
            $('#div0').removeClass('changePosition')
            $('#div1').removeClass('changePosition')
            $('#div2').removeClass('changePosition')
            $('#div3').removeClass('changePosition')
            $('#div4').removeClass('changePosition')
            $('#div5').removeClass('changePosition')
            _this.setState({exceptions:Object.assign([],items),newItem:''})
        }
        setInterval(addData,3000)
    }
    renderException(){
        let i=0
        const {exceptions}=this.state
        if(exceptions){
            return exceptions.map(item=>{
                i++
                return(
                    <div id={'div'+i}
                         style={{background:'red',height:'20px',width:'100px',marginBottom:'5px',position:'relative'}}>
                        {item}
                    </div>
                )
            })
        }
    }
    newException(){
        let {newItem}=this.state
        if(newItem){
            return(
                <div id="div0" style={{background:'red',height:'20px',width:'100px',marginBottom:'5px',position:'relative',display:'block'}}>
                    {newItem}
                </div>
            )
        }
    }
    render() {
        return (
            <section id="platform-appList">
                <div style={{marginLeft:'300px',marginTop:'75px',height:'20px',background:'pink',marginBottom:'5px'}}>
                    {this.newException()}
                </div>
                <div
                    style={{marginLeft:'300px',height:'100px',position:'absolute',overflow: 'hidden'}}
                >
                    {this.renderException()}
                </div>
                <style>
                    {`
                       @-webkit-keyframes changePosition{
                         from {top:0}
                        to {top:25px} }
                        .changePosition{
                         animation: changePosition 2s linear;
                        }
                    `}
                </style>
            </section>
        )
    }
}
export default Test