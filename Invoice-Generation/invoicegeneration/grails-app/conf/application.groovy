//grails.assets.url = "http://localhost:8080/assets/"

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.wkhtmltopdf.binary ="C:/Program Files/wkhtmltopdf/bin/wkhtmltopdf.exe"
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.grailsbrains.auth.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.grailsbrains.auth.UserRole'
grails.plugin.springsecurity.authority.className = 'com.grailsbrains.auth.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
    [pattern: '/dbconsole/**',   access: ['permitAll']],
	[pattern: '/user/register/**', access: ['permitAll']],
	[pattern: '/user/signup/**', 	 access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

