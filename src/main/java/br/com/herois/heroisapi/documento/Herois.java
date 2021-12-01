package br.com.herois.heroisapi.documento;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName ="Heroes_Api_Table")
public class Herois {

    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute (attributeName = "nome")
    private String nome;

    @DynamoDBAttribute (attributeName = "universo")
    private String universo;

    @DynamoDBAttribute (attributeName = "filmes")
    private int filmes;

}
