var React = require('react');
var { Link } = require('react-router');

var Header = React.createClass({
	render: function() {
		return (
			<div className="header">
				<p className="header-info">
					Employee View
				</p>
				<div className="menu">
					<Link  to="/employees" className="menu-link-item" activeClassName="active">Employees</Link>
					<Link  to="/departments" className="menu-link-item" activeClassName="active">Departments</Link>
					<Link  to="/meetings" className="menu-link-item" activeClassName="active">Meetings</Link>
		</div>
			</div>

		);
	}
});

module.exports = Header;
