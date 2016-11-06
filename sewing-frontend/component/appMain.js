/**
 * Created by phoebe.yao on 2016/11/6.
 */

var React = require('react');

var appMain = React.createClass({
    render: function () {
        return (
            <div>
                <div>{this.props.children}</div>
            </div>
        );
    }
});

module.exports = appMain;