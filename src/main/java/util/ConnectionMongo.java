package util;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;

public class ConnectionMongo {
	public static MongoCollection<Document> getConnection() throws Exception{
		try {
			MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
			MongoDatabase database = mongoClient.getDatabase("sistema_academico");
			MongoCollection<Document> collection = database.getCollection("alunos");
			collection.createIndex(new Document("ra", 1), new IndexOptions().unique(true));
			return collection;
		} catch (Exception e) {
			throw new Exception("Erro ao conectar: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
			ConnectionMongo.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
