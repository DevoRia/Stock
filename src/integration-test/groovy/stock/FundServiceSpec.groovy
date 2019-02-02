package stock

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FundServiceSpec extends Specification {

    FundService fundService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Fund(...).save(flush: true, failOnError: true)
        //new Fund(...).save(flush: true, failOnError: true)
        //Fund fund = new Fund(...).save(flush: true, failOnError: true)
        //new Fund(...).save(flush: true, failOnError: true)
        //new Fund(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //fund.id
    }

    void "test get"() {
        setupData()

        expect:
        fundService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Fund> fundList = fundService.list(max: 2, offset: 2)

        then:
        fundList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        fundService.count() == 5
    }

    void "test delete"() {
        Long fundId = setupData()

        expect:
        fundService.count() == 5

        when:
        fundService.delete(fundId)
        sessionFactory.currentSession.flush()

        then:
        fundService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Fund fund = new Fund()
        fundService.save(fund)

        then:
        fund.id != null
    }
}
