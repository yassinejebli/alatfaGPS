package com.alatfa.gps.statistics;

import com.alatfa.gps.model.Chauffeur;
import com.alatfa.gps.model.Mission;
import com.alatfa.gps.model.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.PersistenceContext;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 */

@RestController
@RequestMapping(value = "/Statistics")
public class Statistics {
    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping(value="/Missions", method= RequestMethod.GET)
    public List<JsonClasses.NbrMissionAvecDate> getMissions() {
   /*     Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("month(dateDepart)"),
                Aggregation.sort(Sort.Direction.ASC, Aggregation.previousOperation(), "dateDepart")
        );
*/
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project()
                        .andExpression("dateDepart").extractMonth().as("date"),
                Aggregation.group(Fields.fields().and("date"))
                        .count().as("nbr"),
                Aggregation.project("nbr").and("date").previousOperation()
        );

        AggregationResults groupResults = mongoTemplate.aggregate(
                aggregation, Mission.class, JsonClasses.NbrMissionAvecDate.class);

        List result = groupResults.getMappedResults();

        System.out.println(result);

        return result;
    }

    @RequestMapping(value="/MissionsAccomplished", method= RequestMethod.GET)
    public List<Mission> getMissionAccomplished() {


        Query query = new Query();
        query.addCriteria(Criteria.where("dateDepart").is(new Date()));
        List result = mongoTemplate.find(query,Mission.class);

        System.out.println("Missions d'aujourd'hui : "+result);


        return result;
    }



    @RequestMapping(value="/nbrMissionInAcheve", method= RequestMethod.GET)
    public int nbrMissionInAcheve() {


        Query query = new Query();
        query.addCriteria(Criteria.where("accomplie").is(false));
        List result = mongoTemplate.find(query,Mission.class);


        return result.size();
    }

    @RequestMapping(value="/nbrMissionAcheve", method= RequestMethod.GET)
    public int nbrMissionAcheve() {


        Query query = new Query();
        query.addCriteria(Criteria.where("accomplie").is(true));
        List result = mongoTemplate.find(query,Mission.class);

        return result.size();
    }

    @RequestMapping(value="/nbrVehicules", method= RequestMethod.GET)
    public int nbrVehicules() {


        Query query = new Query();
        List result = mongoTemplate.find(query,Vehicule.class);

        return result.size();
    }

    @RequestMapping(value="/nbrChauffeurs", method= RequestMethod.GET)
    public int nbrChauffeurs() {


        Query query = new Query();
        List result = mongoTemplate.find(query,Chauffeur.class);

        return result.size();
    }
}
