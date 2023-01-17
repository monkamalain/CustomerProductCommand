package ca.tmas.cpc.repository;

import ca.tmas.cpc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

  @Query("select pd from Product pd where pd.refProduct like :ref")
  public Optional<Product> findProductByRef(@Param("ref") String reference);

  @Query("select pd.refProduct from Product pd where pd.refProduct is not null")
  public Set<String> findAllRefProduct();

  @Query("select count(pd) as Total from Product pd where pd.stateProduct = :state")
  public long countAllProductByStateAvailable(@Param("state") String state);

  @Query("select count(pd) as Total from Product pd where pd.stateProduct = :state")
  public long countAllProductByStateUnavailable(@Param("state") String state);

  @Query("select pd from Product pd where pd.stateProduct like :state")
  public List<Product> findAllProductByStateAvailable(@Param("state") String state);

  @Query("select pd from Product pd where pd.stateProduct like :etat")
  public List<Product> findAllProductByStateUnavailable(@Param("etat") String state);

  @Query("select pd from Product pd where pd.priceProduct = :price")
  public List<Product> findProductByPrice(@Param("price") double price);

  @Query("select pd from Product pd where pd.priceProduct >= :price1 and pd.priceProduct <= :price2")
  public List<Product> findProductByPriceBetween(@Param("price1") double price1, @Param("price2") double price2);

  @Query("select pd from Product pd where pd.creationDateProduct = :creationDate")
  public List<Product> findProductByCreationDate(@Param("creationDate") LocalDateTime creationDate);

  @Query("select pd from Product pd where pd.dateSaleProduct = :saleDate")
  public List<Product> findProductBySaleDate(@Param("saleDate") LocalDateTime saleDate);

  @Query("select sum(pd.priceProduct) as Total from Product pd where pd.dateSaleProduct = :saleDate")
  public double findProductBySaleDateAndPrice(@Param("saleDate") LocalDateTime saleDate1, @Param("saleDate") LocalDateTime saleDate2);

}
