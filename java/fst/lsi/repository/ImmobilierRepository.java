package fst.lsi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import fst.lsi.entities.Immobilier;

public interface ImmobilierRepository extends MongoRepository<Immobilier, Integer> {

}
