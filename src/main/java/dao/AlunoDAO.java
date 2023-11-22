package dao;

import java.security.Identity;
import java.util.ArrayList;
import java.util.List;


import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;

import model.Aluno;
import util.ConnectionMongo;

public class AlunoDAO {
	private MongoCollection<Document> collection;
	
	public AlunoDAO() throws Exception {
		try {
			this.collection = ConnectionMongo.getConnection();
		}catch (Exception e) {
			throw e;
		}
	}
	
	public void salvar(Aluno aluno) throws Exception {
		if(aluno == null) {
			throw new Exception("O valor passado não pode ser nulo");
		}
		try {
			Document document = new Document()
				.append("ra", aluno.getRa())
				.append("nome", aluno.getNome())
				.append("email", aluno.getEmail())
				.append("data_nascimento", aluno.getDataNascimento())	
				.append("endereco", aluno.getEndereco())			
				.append("periodo", aluno.getPeriodo());				
			
			collection.insertOne(document);
		} catch (Exception e) {
			throw new Exception("Erro ao inserir dados " + e.getMessage());
		}
	}
	
	public List<Aluno> listar() throws Exception {
		List<Aluno> lista = new ArrayList<Aluno>();
		try {
			Bson projectionFieldsBson = Projections.fields(Projections.excludeId());
			
			MongoCursor<Document> cursor = collection.find().projection(projectionFieldsBson).iterator();
			
			while (cursor.hasNext()) {
				Document document = cursor.next();
				Aluno al = new Aluno();
				al.setRa(document.getString("ra"));
				al.setNome(document.getString("nome"));
				al.setEmail(document.getString("email"));
				al.setDataNascimento(document.getString("data_nascimento"));
				al.setEndereco(document.getString("endereco"));
				al.setPeriodo(document.getString("periodo"));
				lista.add(al);
				
			}
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro ao listar alunos: " + e.getMessage());
		}
	}
	
	public void atualizar(Aluno aluno) throws Exception {
		if(aluno == null) {
			throw new Exception("Valor vão pode ser nulo");
		}
		try {
			Document query =  new Document().append("ra", aluno.getRa());
			List<Bson> updateList = new ArrayList<>();
			if(!aluno.getNome().isEmpty()) {
				updateList.add(Updates.set("nome", aluno.getNome()));				
			}
			if(!aluno.getEmail().isEmpty()) {
				updateList.add(Updates.set("email", aluno.getEmail()));
			}
			if(!aluno.getDataNascimento().isEmpty()) {
				updateList.add(Updates.set("data_nascimento", aluno.getDataNascimento()));				
			}
			if(!aluno.getEndereco().isEmpty()) {
				updateList.add(Updates.set("endereco", aluno.getEndereco()));				
			}
			if(!aluno.getPeriodo().equals("Selecione o periodo")) {
				updateList.add(Updates.set("periodo", aluno.getPeriodo()));				
			}

			Bson updates = Updates.combine(updateList);
			
			collection.updateOne(query, updates);
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar dados: " + e.getMessage());
		}
	}
	
	public void excluir(Aluno aluno) throws Exception {
		if (aluno.getRa().matches(".*[^0-9].*")) {
			throw new Exception("Ra inválido");
		}
		try {
			Bson queryBson = Filters.eq("ra", aluno.getRa());
			DeleteResult result = collection.deleteOne(queryBson);
			if (result.getDeletedCount() < 1) {
				throw new Exception("Aluno não encontrado");
			}
		} catch (Exception e) {
			throw new Exception("Erro ao deletar aluno: " + e.getMessage());
		}
	}
	
	public Aluno consultar(String ra) throws Exception {
		if (ra.matches(".*[^0-9].*")) {
			throw new Exception("Ra inválido");
		}
		try {
			Aluno al = new Aluno();
			Bson projectionField = Projections.excludeId();
			
			Document document = collection.find(Filters.eq("ra", ra))
					.projection(projectionField)
					.first();
			if (document == null) {
				throw new Exception("Aluno não encontrado");
			}
			al.setRa(document.getString("ra"));
			al.setNome(document.getString("nome"));
			al.setEmail(document.getString("email"));
			al.setDataNascimento(document.getString("data_nascimento"));
			al.setEndereco(document.getString("endereco"));
			al.setPeriodo(document.getString("periodo"));
			return al;
			
		} catch (Exception e) {
			throw new Exception("Erro ao consultar aluno: " + e.getMessage());
		}
	}
}
