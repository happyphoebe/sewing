/**
 * Created by phoebe.yao on 2016/11/6.
 */

var React = require('react');
var ReactDom = require('react-dom');
var ReactRouter = require('react-router');
var History = require('history');

var AppMain = require('./component/appMain');
var IndexMain = require('./component/content/index/indexMain');

var HistoryConfig = ReactRouter.useRouterHistory(History.createHashHistory)({queryKey: false});
var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var IndexRedirect = ReactRouter.IndexRedirect;

var routes = (<Route path="/" component={AppMain}>
    <Route path="index" component={IndexMain} />
    <IndexRedirect to="/index" />
</Route>);

ReactDom.render(<Router routes={routes} history={HistoryConfig}></Router>, document.getElementById("app"));
