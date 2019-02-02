package stock

class BootStrap {

    def init = { servletContext ->
        def authorities = ['USER', 'ADMIN']
        authorities.each {
            if ( !Role.findByAuthority(it) ) {
                new Role(authority: it).save()
            }
        }
        if ( !User.findByUsername('admin') ) {
            def u = new User(username: 'admin', password: 'admin')
            u.save()
            def ur = new UserRole(user: u, role: Role.findByAuthority('ADMIN'))
            ur.save()
            new Fund(name: "Stock", description: "Main fund", timestamp: new Date()).save()
            new Fund(name: "Investment", description: "", timestamp: new Date()).save()
            new Fund(name: "Charity", description: "", timestamp: new Date()).save()
            new Fund(name: "Consumer", description: "", timestamp: new Date()).save()
            new Fund(name: "Subsistence", description: "", timestamp: new Date()).save()
            new Fund(name: "Realization", description: "", timestamp: new Date()).save()
        }


    }
    def destroy = {
    }
}
