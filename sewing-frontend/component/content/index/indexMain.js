/**
 * Created by phoebe.yao on 2016/11/6.
 */

var React = require('react');
var ReactRouter = require('react-router');
var hashHistory = ReactRouter.hashHistory;
var Service = require('../../../service/service.js');
var CONST_APP = require('../../../config/constant.js');

var indexMain = React.createClass({

    render: function () {
        return (
            <div>
                Welcome!
            </div>
        );
    },
});

module.exports = indexMain;