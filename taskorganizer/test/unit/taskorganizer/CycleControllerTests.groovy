package taskorganizer



import org.junit.*
import grails.test.mixin.*

/**
 * CycleControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(CycleController)
@Mock(Cycle)
class CycleControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/cycle/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.cycleInstanceList.size() == 0
        assert model.cycleInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.cycleInstance != null
    }

    void testSave() {
        controller.save()

        assert model.cycleInstance != null
        assert view == '/cycle/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/cycle/show/1'
        assert controller.flash.message != null
        assert Cycle.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/cycle/list'


        populateValidParams(params)
        def cycle = new Cycle(params)

        assert cycle.save() != null

        params.id = cycle.id

        def model = controller.show()

        assert model.cycleInstance == cycle
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/cycle/list'


        populateValidParams(params)
        def cycle = new Cycle(params)

        assert cycle.save() != null

        params.id = cycle.id

        def model = controller.edit()

        assert model.cycleInstance == cycle
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/cycle/list'

        response.reset()


        populateValidParams(params)
        def cycle = new Cycle(params)

        assert cycle.save() != null

        // test invalid parameters in update
        params.id = cycle.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/cycle/edit"
        assert model.cycleInstance != null

        cycle.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/cycle/show/$cycle.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        cycle.clearErrors()

        populateValidParams(params)
        params.id = cycle.id
        params.version = -1
        controller.update()

        assert view == "/cycle/edit"
        assert model.cycleInstance != null
        assert model.cycleInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/cycle/list'

        response.reset()

        populateValidParams(params)
        def cycle = new Cycle(params)

        assert cycle.save() != null
        assert Cycle.count() == 1

        params.id = cycle.id

        controller.delete()

        assert Cycle.count() == 0
        assert Cycle.get(cycle.id) == null
        assert response.redirectedUrl == '/cycle/list'
    }
}
