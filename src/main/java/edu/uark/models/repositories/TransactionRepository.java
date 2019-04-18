package edu.uark.models.repositories;

import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.helpers.PostgreFunctionType;
import edu.uark.dataaccess.repository.helpers.SQLComparisonType;
import edu.uark.dataaccess.repository.helpers.where.WhereClause;
import edu.uark.dataaccess.repository.helpers.where.WhereContainer;
import edu.uark.models.entities.ProductEntity;
import edu.uark.models.entities.fieldnames.ProductFieldNames;
import edu.uark.models.repositories.interfaces.ProductRepositoryInterface;

import java.sql.SQLException;



public class TransactionRepository extends BaseRepository<TransactionEntity> implements TransactionRepositoryInterface {
    @Override
    public TransactionEntity byLookupCode(String lookupCode) {
        return this.firstOrDefaultWhere(
                new WhereContainer(
                        (new WhereClause()).
                                postgreFunction(PostgreFunctionType.LOWER).
                                table(this.primaryTable).
                                fieldName(ProductFieldNames.LOOKUP_CODE).
                                comparison(SQLComparisonType.EQUALS)
                ),
                (ps) -> {
                    try {
                        ps.setObject(1, lookupCode.toLowerCase());
                    } catch (SQLException e) {}

                    return ps;
                }
        );
    }