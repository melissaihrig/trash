import stakeholder.*

class BootStrap {

    def init = { servletContext ->

		def c1 = new Customer(companyName: "Bastardos sin gloria", ratingPoints: 10)
		c1.save()

		def c2 = new Customer(companyName: "La bella y la bestia", ratingPoints: 8)
		c2.save()

		def c3 = new Customer(companyName: "La bandolina del capitán Corelli", ratingPoints: 5)
		c3.save()

		def c4 = new Customer(companyName: "Esperando la carroza", ratingPoints: 5)
		c4.save()

		def c5 = new Customer(companyName: "Inframundo", ratingPoints: 7)
		c5.save()

    }
    def destroy = {
    }
}
