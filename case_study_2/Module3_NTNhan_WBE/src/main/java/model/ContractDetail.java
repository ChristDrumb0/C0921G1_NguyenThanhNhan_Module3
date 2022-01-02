package model;

public class ContractDetail {
    int contractDetailId;
    int contractId;
    int attachServiceId;
    int contractDetailQuantity;

    public ContractDetail() {
    }

    public ContractDetail(int contractDetailId, int contractId, int attachServiceId, int contractDetailQuantity) {
        this.contractDetailId = contractDetailId;
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.contractDetailQuantity = contractDetailQuantity;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public int getContractDetailQuantity() {
        return contractDetailQuantity;
    }

    public void setContractDetailQuantity(int contractDetailQuantity) {
        this.contractDetailQuantity = contractDetailQuantity;
    }
}
