package com.techelevator.dao;

import com.techelevator.tenmo.dao.JdbcTransferDao;
import com.techelevator.tenmo.dao.JdbcUserDao;
import com.techelevator.tenmo.exception.MessageSenderIsReceiver;
import com.techelevator.tenmo.exception.MessageTransferNotPositive;
import com.techelevator.tenmo.exception.TransferFieldBlank;
import com.techelevator.tenmo.exception.TransferNotFoundException;
import com.techelevator.tenmo.model.Transfer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

public class JdbcTransferDaoTest extends BaseDaoTests {

    private JdbcTransferDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcTransferDao(jdbcTemplate);
    }


    @Test(expected = TransferFieldBlank.class)
    public void transferRecevierBlankReturnsError() {
        Transfer testTransfer = new Transfer();
        testTransfer.setSender(1001);
        testTransfer.setTransfer_amount(BigDecimal.valueOf(200));

        Transfer createdTransfer = sut.sendTransfer(testTransfer);


    }


    @Test(expected = TransferFieldBlank.class)
    public void transferSenderBlankReturnsError() {
        Transfer testTransfer = new Transfer();
        testTransfer.setReceiver(2002);
        testTransfer.setTransfer_amount(BigDecimal.valueOf(200));

        Transfer createdTransfer = sut.sendTransfer(testTransfer);


    }

    @Test(expected = TransferFieldBlank.class)
    public void transferAmount_transfered_BlankReturnsError() {
        Transfer testTransfer = new Transfer();
        testTransfer.setSender(2001);
        testTransfer.setReceiver(2002);

        Transfer createdTransfer = sut.sendTransfer(testTransfer);
    }


    @Test(expected = TransferFieldBlank.class)
    public void transfer_to_unknown_user() {
        Transfer testTransfer = new Transfer();
        testTransfer.setSender(2001);
        testTransfer.setReceiver(4500);
        testTransfer.setTransfer_amount(BigDecimal.valueOf(200));

        Transfer createdTransfer = sut.sendTransfer(testTransfer);


    }

    //Catching in the wrong error message; should catch at MessageTransferNotPositive
    @Test(expected = TransferFieldBlank.class)
    public void transfer_amount_not_positive() {
        Transfer testTransfer = new Transfer();
        testTransfer.setSender(2002);
        testTransfer.setReceiver(2001);
        testTransfer.setTransfer_amount(BigDecimal.valueOf(-100, 2));

        Transfer createdTransfer = sut.sendTransfer(testTransfer);


    }

    //Catches in postman and throws MessageTransferNotPositive
    @Test(expected = MessageTransferNotPositive.class)
    public void transfer_amount_less_than_one() {
        Transfer testTransfer = new Transfer();
        testTransfer.setSender(2002);
        testTransfer.setReceiver(2001);
        testTransfer.setTransfer_amount(BigDecimal.valueOf(1, 2));

        Transfer createdTransfer = sut.sendTransfer(testTransfer);


    }
    //still throws com.techelevator.tenmo.exception.TransferFieldBlank: Your Transfer field is incorrect. Please update.

    @Test
    public void createTransferTest() {
        Transfer testTransfer = new Transfer();
        testTransfer.setSender(2002);
        testTransfer.setReceiver(2001);
        testTransfer.setTransfer_amount(BigDecimal.valueOf(100));

        Transfer createdTransfer = sut.sendTransfer(testTransfer);

        Integer newId = createdTransfer.getTransferId();
        Assert.assertTrue(newId > 3);
        testTransfer.setTransferId(newId);

        Transfer actualTransfer = new Transfer();
        actualTransfer.setTransferId(newId);
        actualTransfer.setSender(2002);
        actualTransfer.setTransfer_amount(BigDecimal.valueOf(100));

        Assert.assertEquals(actualTransfer, testTransfer);

    }
    //Postman throws correct MessageSenderIsReceiver but here we get
    //java.lang.Exception: Unexpected exception, expected<com.techelevator.tenmo.exception.MessageSenderIsReceiver> but was<com.techelevator.tenmo.exception.TransferFieldBlank>
    //from the jdbcdao try/catch
    @Test(expected = MessageSenderIsReceiver.class)
    public void Sender_cannot_equal_receiver() {
        Transfer testTransfer = new Transfer();
        testTransfer.setSender(2002);
        testTransfer.setReceiver(2002);
        testTransfer.setTransfer_amount(BigDecimal.valueOf(100));

        Transfer createdTransfer = sut.sendTransfer(testTransfer);

    }
}
