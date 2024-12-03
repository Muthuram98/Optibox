package MapView;

import java.util.logging.Logger;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.openqa.selenium.WebDriver;

public class mongdb {

	public static void main(String[] args) {
		
		String location = "FJLTK";
        String equipmentType = "20DY";

        // MongoDB connection string
        String connectionString = "mongodb://localhost:27017"; 
        
        
		/*
		 * If user has credential
		 * String username = "yourUsername"; // Replace with your MongoDB username
		 * String password = "yourPassword"; // Replace with your MongoDB password
		 * String databaseName = "yourDatabase"; // Replace with your database name
		 * String host = "localhost"; // MongoDB host int port = 27017; // MongoDB port
		 * 
		 * // Connection string with authentication String connectionString =
		 * String.format("mongodb://%s:%s@%s:%d/%s", username, password, host, port,
		 * databaseName);
		 */
      
        
        
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

        	MongoDatabase database = mongoClient.getDatabase("DeficitSurplus"); 
            MongoCollection<Document> collection = database.getCollection("Grid"); 

            Document query = new Document("Destination", location) 
                    .append("Box Type", equipmentType);

            System.out.println("Executing query: " + query.toJson());

            FindIterable<Document> result = collection.find(query);

            boolean dataFound = false;
            for (Document doc : result) {
                dataFound = true;
                int qty = doc.getInteger("Sum of Qty (Units)", 0); 
                System.out.println("Sum of Qty (Units): " + qty);
            }

            if (!dataFound) {
                System.out.println("No documents match the given query.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
