package com.tripoin.scaffolding.dao;

import com.tripoin.scaffolding.dao.exception.DAOException;
import com.tripoin.scaffolding.data.IScaffoldingConstant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.io.Serializable;

/**
 * created on 10/17/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <ID>
 */
@Transactional
public interface IApprovalDAO<ID extends Serializable> {

	@Modifying
    @Query("UPDATE #{#entityName} a set a.status = "+IScaffoldingConstant.Query.APPROVED)
    void approveAll() throws DAOException;

    @Modifying
    @Query("UPDATE #{#entityName} a set a.status = "+IScaffoldingConstant.Query.APPROVED+" where a.id = ?1")
    void approveSingleData(ID p_Id) throws DAOException;
}
