package stock

import grails.gorm.services.Service

@Service(Fund)
interface FundService {

    Fund get(Serializable id)

    List<Fund> list(Map args)

    Long count()

    void delete(Serializable id)

    Fund save(Fund fund)

}