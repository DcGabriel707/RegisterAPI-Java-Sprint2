package edu.uark.models.repositories;

import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.dataaccess.repository.helpers.PostgreFunctionType;
import edu.uark.dataaccess.repository.helpers.SQLComparisonType;
import edu.uark.dataaccess.repository.helpers.where.WhereClause;
import edu.uark.dataaccess.repository.helpers.where.WhereContainer;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.entities.ProductEntity;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

import java.sql.SQLException;

public class TransactionRepository extends BaseRepository<TransactionEntity> implements TransactionRepositoryInterface {
	@Override
	public TransactionEntity byCashierId(int cashierId) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause())
					.table(this.primaryTable)
					.fieldName(TransactionFieldNames.CASHIER_ID)
					.comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, cashierId);
				} catch (SQLException e) {}

				return ps;
			}
		);
	}
	public TransactionEntity createOne() {
		return new TransactionEntity();
	}
	
	public TransactionRepository() {
		super(DatabaseTable.TRANSACTION);
	}
}