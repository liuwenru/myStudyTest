package org.ijarvis.EpointTest.MongodbTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSONParseException;
import org.bson.BSON;
import org.bson.Document;
import com.mongodb.client.model.Projections.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Filters;
import org.bson.json.JsonParseException;

import javax.print.Doc;

import static com.mongodb.client.model.Projections.include;

/**
 * Created by ijarvis on 12/28/16.
 */
public class MongodbTest {
    class info {
        private String value;

        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }
    }
    public  static  void  main(String[] arg) throws UnknownHostException {
//
//        String ipaddr= InetAddress.getLocalHost().getHostAddress();
//        System.out.println(ipaddr);


//        MongoClient mongoClient = new MongoClient( "192.168.201.57" , 27017 );
//        MongoDatabase mongoDatabase = mongoClient.getDatabase("metric");
//        MongoCollection<Document> collection = mongoDatabase.getCollection("01bb191f-e95b-4f51-abb0-bbf6989a5a4a.host.df.boot.total");
////        Map<String, Object> map=new HashMap<String, Object>();
////        map.put("$gt","1482915799.804");
////        map.put("$lt","1483915799");
////        Document tmp=new Document("time",map);
//        String query1="{\"$or\":[{\"time\":{\"$gt\":\"1482915799.804\",\"$lt\":\"1483915799\"}},{\"_id\":{\"$gte\":ObjectId(\"58639784e93963bb26aaa308\")}}]}";
//        BasicDBObject tmp1=BasicDBObject.parse(query1);
//        BasicDBObject fild=BasicDBObject.parse("{}");
//        FindIterable<Document> findIterable = collection.find(tmp1).projection(fild);
//        MongoCursor<Document> mongoCursor = findIterable.iterator();
//        while(mongoCursor.hasNext()){
//            Document tmp=mongoCursor.next();
//            Iterator iterator=tmp.keySet().iterator();
//            while (iterator.hasNext())
//            {
//                String key=(String) iterator.next();
//                System.out.println(key+"-----"+tmp.get(key));
//
//            }
//        }
//        String testquery=" {find: \"01bb191f-e95b-4f51-abb0-bbf6989a5a4a.host.df.proc.fs.nfsd.total\",filter:{\"$or\":[{\"time\":{\"$gt\":\"1482915799.804\",\"$lt\":\"1483915799\"}},{\"_id\":{\"$gte\":ObjectId(\"58639784e93963bb26aaa308\")}}]},projection:{value:1,_id:0},batchSize:5,limit: 2000}";
//        String qu="{buildinfo,1}";
//        Document t1= Document.parse(qu);
//        System.out.println(t1.toString());
////        Document buildInfo = mongoDatabase.runCommand(Document.parse(testquery));
////        System.out.println(buildInfo);
//        Document buildInfo = mongoDatabase.runCommand(t1);
//        System.out.println(buildInfo);

//        Block<Document> printBlock = new Block<Document>() {
//            @Override
//            public void apply(final Document document) {
//                System.out.println(document.toJson());
//            }
//        };
    }

}
