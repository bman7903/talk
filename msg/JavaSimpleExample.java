import java.net.UnknownHostException;
import com.mongodb.*;


public class JavaSimpleExample {

    // Extra helper code

    public static BasicDBObject[] createSeedData(){
        
        BasicDBObject seventies = new BasicDBObject();
        seventies.put("decade", "1970s");
        seventies.put("artist", "Debby Boone");
        seventies.put("song", "You Light Up My Life");
        seventies.put("weeksAtOne", 10);
        
        BasicDBObject eighties = new BasicDBObject();
        eighties.put("decade", "1980s");
        eighties.put("artist", "Olivia Newton-John");
        eighties.put("song", "Physical");
        eighties.put("weeksAtOne", 10);
        
        BasicDBObject nineties = new BasicDBObject();
        nineties.put("decade", "1990s");
        nineties.put("artist", "Mariah Carey");
        nineties.put("song", "One Sweet Day");
        nineties.put("weeksAtOne", 16);
        
        final BasicDBObject[] seedData = {seventies, eighties, nineties};
        
        return seedData;
    }
    
    public static void main(String[] args) throws UnknownHostException{
        
        // Create seed data
        
        final BasicDBObject[] seedData = createSeedData();
        
        // Standard URI format: mongodb://[dbuser:dbpassword@]host:port/dbname
       
        MongoClientURI uri  = new MongoClientURI("mongodb://makolab12:GofuckyourselF@ds039504.mongolab.com:39504/email"); 
        MongoClient client = new MongoClient(uri);
        DB db = client.getDB(uri.getDatabase());
        
        DBCollection songs = db.getCollection("songs");
        
        songs.insert(seedData);
       
        BasicDBObject updateQuery = new BasicDBObject("song", "One Sweet Day");
        songs.update(updateQuery, new BasicDBObject("$set", new BasicDBObject("artist", "Mariah Carey ft. Boyz II Men")));
              
        BasicDBObject findQuery = new BasicDBObject("weeksAtOne", new BasicDBObject("$gte",10));
        BasicDBObject orderBy = new BasicDBObject("decade", 1);

        DBCursor docs = songs.find(findQuery).sort(orderBy);

        while(docs.hasNext()){
            DBObject doc = docs.next();
            System.out.println(
                "In the " + doc.get("decade") + ", " + doc.get("song") + 
                " by " + doc.get("artist") + " topped the charts for " + 
                doc.get("weeksAtOne") + " straight weeks."
            );
        }
        // song.drop();
        client.close();
    }
}
