package edu.uark.commands.transaction;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Product;
import edu.uark.models.entities.ProductEntity;
import edu.uark.models.repositories.ProductRepository;
import edu.uark.models.repositories.interfaces.ProductRepositoryInterface;
import org.apache.commons.lang3.StringUtils;

public class TransactionByLookupQuery implements ResultCommandInterface<Transaction> {
	@Override
	public Product execute() {
		if (StringUtils.isBlank(this.lookupCode)) {
			throw new UnprocessableEntityException("lookupcode");
		}

		ProductEntity productEntity = this.productRepository.byLookupCode(this.lookupCode);
		if (productEntity != null) {
			return new Product(productEntity);
		} else {
			throw new NotFoundException("Product");
		}
	}

	//Properties
	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public TransactionByLookupQuery setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
		return this;
	}

	private ProductRepositoryInterface productRepository;
	public ProductRepositoryInterface getProductRepository() {
		return this.productRepository;
	}
	public TransactionByLookupQuery setProductRepository(ProductRepositoryInterface productRepository) {
		this.productRepository = productRepository;
		return this;
	}

	public TransactionByLookupQuery() {
		this.productRepository = new ProductRepository();
	}
}
