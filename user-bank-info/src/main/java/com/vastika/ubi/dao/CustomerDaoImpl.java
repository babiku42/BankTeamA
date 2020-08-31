package com.vastika.ubi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.DbDoc;
import com.vastika.ubi.module.AccountBalance;
import com.vastika.ubi.module.AccountInfo;
import com.vastika.ubi.util.DbUtil;

public class CustomerDaoImpl implements CustomerDao {
	public static final String INSERT_SQl = "insert into account_info_tbl(account_name, address, mobileNo, idType)values(?,?,?,?)";
	public static final String DEPOSIT_SQL = "insert into account_balance_tbl(idType, depositAmount, withdrawAmount, balance)values(?,?,?,?)";
	public static final String WITHDRAW_SQL = "insert into account_balance_tbl(idType, depositAmount, withdrawAmount, balance)values(?,?,?,?)";
	public static final String GET_BY_ID_SQl = "select * from account_balance_tbl where idType=?";

	@Override
	public int openAccount(AccountInfo info) {
		int opened = 0;
		try (Connection con = DbUtil.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT_SQl);) {
			ps.setString(1, info.getAccount_name());
			ps.setString(2, info.getAddress());
			ps.setLong(3, info.getMobileNo());
			ps.setInt(4, info.getIdType());
			opened = ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return opened;
	}

	@Override
	public int depositAccount(AccountBalance balance) {
		int deposited=0;
		try(
		Connection con= DbUtil.getConnection();
				PreparedStatement ps= con.prepareStatement(DEPOSIT_SQL);){
			ps.setInt(1, balance.getIdType());
			ps.setDouble(2, balance.getDepositAmount());
			ps.setDouble(3, balance.getWithdrawAmount());
			ps.setDouble(4, balance.getBalance());
			deposited=ps.executeUpdate();
			
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return deposited;
	}

	@Override
	public int withdrawAccount(AccountBalance balance) {
		int withdraw = 0;
		try (Connection con = DbUtil.getConnection(); PreparedStatement ps = con.prepareStatement(WITHDRAW_SQL);) {
			ps.setInt(1, balance.getIdType());
			ps.setDouble(2, balance.getDepositAmount());
			ps.setDouble(3, balance.getWithdrawAmount());
			ps.setDouble(4, balance.getBalance());
			
			withdraw = ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return withdraw;
	}

	@Override
	public AccountBalance showall(int idType) {
AccountBalance balances= new AccountBalance();
try (
        Connection con = DbUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_BY_ID_SQl);) {

    ps.setInt(1, idType);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        balances.setIdType(rs.getInt("idType"));
        balances.setDepositAmount(rs.getDouble("depositAmount"));
        balances.setWithdrawAmount(rs.getDouble("withdrawAmount"));
        balances.setBalance(rs.getDouble("balance"));
        balances.setId(rs.getInt("id"));

    }

} catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
}
return balances;

	}
}
	
