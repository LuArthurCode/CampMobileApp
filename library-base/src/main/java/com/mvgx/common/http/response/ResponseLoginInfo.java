package com.mvgx.common.http.response;

import java.io.Serializable;
import java.math.BigDecimal;

public class ResponseLoginInfo implements Serializable {


    /**
     * id : 167
     * walletAddress : 0x6efa71c1bd12c452c3e7ef90dcf15aee2237c167
     * walletName : Cold Wallet
     * keyId : 423jz0l3Ql2NEh2jJLfwG8ImhC37
     * preSignId : 050a3EkRc8Q4QMAQHpSfMi000000
     * referenceNumber : W202303070000001
     * network : ETH
     * nonce : 39
     * balanceDelta : 1000000
     * amount : 1
     * currencyId : UST
     * currencyName : Tether USD
     * toAddress : 0xcf1Ee422867709b2Bc3989b61Ccf48F05751215D
     * toName : yu.miao's wallet
     * gasFee : 2772284674
     * signatureA : 00720009736563703235366b31004104cf5c0dac95c1577f2d5e88f3abaa6a12a949992146c64ca201238fd15dd9296ab8669d7fa85e35af83a3d292a9a6bcaf14c35f8bde27a9f6135c40ad2cf9ee080020efdcb2c76ce64063ab7c4b41100466ecdc1d5e543627ca21e869082b7df3ecb5
     * signatureB : null
     * signatureC : null
     * signatureD : null
     * signatureE : null
     * encodedSignedTx : null
     * transactionHash : null
     * contractAddress : 0xED2188e40ee30192231209C0e527B22a41d0BdEa
     * data : 0xa9059cbb000000000000000000000000cf1ee422867709b2bc3989b61ccf48f05751215d00000000000000000000000000000000000000000000000000000000000f4240
     * status : 1
     * gmtCreate : 1678240882000
     * gmtExecute : null
     * gmtModified : 1678240882000
     * type : 1
     */

    private BigDecimal id;
    private String walletAddress;
    private String walletName;
    private String keyId;
    private String preSignId;
    private String referenceNumber;
    private String network;
    private BigDecimal nonce;
    private BigDecimal balanceDelta;
    private BigDecimal amount;
    private String currencyId;
    private String currencyName;
    private String toAddress;
    private String toName;
    private BigDecimal gasFee;
    private String signatureA;
    private String signatureB;
    private String signatureC;
    private String signatureD;
    private String signatureE;
    private String encodedSignedTx;
    private String transactionHash;
    private String contractAddress;
    private String data;
    private BigDecimal status;
    private long gmtCreate;
    private String gmtExecute;
    private BigDecimal gmtModified;
    private BigDecimal type;
    private int approvedLevel;
    private boolean systemSignFlag;

    public boolean isSystemSignFlag() {
        return systemSignFlag;
    }

    public void setSystemSignFlag(boolean systemSignFlag) {
        this.systemSignFlag = systemSignFlag;
    }
    public long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public int getApprovedLevel() {
        return approvedLevel;
    }

    public void setApprovedLevel(int approvedLevel) {
        this.approvedLevel = approvedLevel;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getWalletAddress() {
        return walletAddress == null ? "" : walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress == null ? "" : walletAddress;
    }

    public String getWalletName() {
        return walletName == null ? "" : walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName == null ? "" : walletName;
    }

    public String getKeyId() {
        return keyId == null ? "" : keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId == null ? "" : keyId;
    }

    public String getPreSignId() {
        return preSignId == null ? "" : preSignId;
    }

    public void setPreSignId(String preSignId) {
        this.preSignId = preSignId == null ? "" : preSignId;
    }

    public String getReferenceNumber() {
        return referenceNumber == null ? "" : referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber == null ? "" : referenceNumber;
    }

    public String getNetwork() {
        return network == null ? "" : network;
    }

    public void setNetwork(String network) {
        this.network = network == null ? "" : network;
    }

    public BigDecimal getNonce() {
        return nonce;
    }

    public void setNonce(BigDecimal nonce) {
        this.nonce = nonce;
    }

    public BigDecimal getBalanceDelta() {
        return balanceDelta;
    }

    public void setBalanceDelta(BigDecimal balanceDelta) {
        this.balanceDelta = balanceDelta;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrencyId() {
        return currencyId == null ? "" : currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId == null ? "" : currencyId;
    }

    public String getCurrencyName() {
        return currencyName == null ? "" : currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName == null ? "" : currencyName;
    }

    public String getToAddress() {
        return toAddress == null ? "" : toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress == null ? "" : toAddress;
    }

    public String getToName() {
        return toName == null ? "" : toName;
    }

    public void setToName(String toName) {
        this.toName = toName == null ? "" : toName;
    }

    public BigDecimal getGasFee() {
        return gasFee;
    }

    public void setGasFee(BigDecimal gasFee) {
        this.gasFee = gasFee;
    }

    public String getSignatureA() {
        return signatureA == null ? "" : signatureA;
    }

    public void setSignatureA(String signatureA) {
        this.signatureA = signatureA == null ? "" : signatureA;
    }

    public String getSignatureB() {
        return signatureB == null ? "" : signatureB;
    }

    public void setSignatureB(String signatureB) {
        this.signatureB = signatureB == null ? "" : signatureB;
    }

    public String getSignatureC() {
        return signatureC == null ? "" : signatureC;
    }

    public void setSignatureC(String signatureC) {
        this.signatureC = signatureC == null ? "" : signatureC;
    }

    public String getSignatureD() {
        return signatureD == null ? "" : signatureD;
    }

    public void setSignatureD(String signatureD) {
        this.signatureD = signatureD == null ? "" : signatureD;
    }

    public String getSignatureE() {
        return signatureE == null ? "" : signatureE;
    }

    public void setSignatureE(String signatureE) {
        this.signatureE = signatureE == null ? "" : signatureE;
    }

    public String getEncodedSignedTx() {
        return encodedSignedTx == null ? "" : encodedSignedTx;
    }

    public void setEncodedSignedTx(String encodedSignedTx) {
        this.encodedSignedTx = encodedSignedTx == null ? "" : encodedSignedTx;
    }

    public String getTransactionHash() {
        return transactionHash == null ? "" : transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash == null ? "" : transactionHash;
    }

    public String getContractAddress() {
        return contractAddress == null ? "" : contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress == null ? "" : contractAddress;
    }

    public String getData() {
        return data == null ? "" : data;
    }

    public void setData(String data) {
        this.data = data == null ? "" : data;
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }



    public String getGmtExecute() {
        return gmtExecute == null ? "" : gmtExecute;
    }

    public void setGmtExecute(String gmtExecute) {
        this.gmtExecute = gmtExecute == null ? "" : gmtExecute;
    }

    public BigDecimal getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(BigDecimal gmtModified) {
        this.gmtModified = gmtModified;
    }

    public BigDecimal getType() {
        return type;
    }

    public void setType(BigDecimal type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "ResponseWalletListInfo{" +
                "id=" + id +
                ", walletAddress='" + walletAddress + '\'' +
                ", walletName='" + walletName + '\'' +
                ", keyId='" + keyId + '\'' +
                ", preSignId='" + preSignId + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", network='" + network + '\'' +
                ", nonce=" + nonce +
                ", balanceDelta=" + balanceDelta +
                ", amount=" + amount +
                ", currencyId='" + currencyId + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", toName='" + toName + '\'' +
                ", gasFee=" + gasFee +
                ", signatureA='" + signatureA + '\'' +
                ", signatureB='" + signatureB + '\'' +
                ", signatureC='" + signatureC + '\'' +
                ", signatureD='" + signatureD + '\'' +
                ", signatureE='" + signatureE + '\'' +
                ", encodedSignedTx='" + encodedSignedTx + '\'' +
                ", transactionHash='" + transactionHash + '\'' +
                ", contractAddress='" + contractAddress + '\'' +
                ", data='" + data + '\'' +
                ", status=" + status +
                ", gmtCreate=" + gmtCreate +
                ", gmtExecute='" + gmtExecute + '\'' +
                ", gmtModified=" + gmtModified +
                ", type=" + type +
                ", approvedLevel=" + approvedLevel +
                '}';
    }
}
