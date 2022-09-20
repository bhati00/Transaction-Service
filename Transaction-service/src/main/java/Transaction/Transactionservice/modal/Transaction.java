package Transaction.Transactionservice.modal;





import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transaction  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int transcId;
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    private int externalId;
    @NotNull
    private UUID userId;

    @NotNull
    private UUID merchantId;

    @NotNull
    private UUID clientReferenceId;
    @NotNull
    double amount;
    /*public enum Type{
        Created,Pending,Approved,Rejected,Expired,
    }
    @Enumerated(EnumType.STRING)
    private Status status;  */

    private String createdBy;

    private String updateBy;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

 public void setTranscId(int transcId) {
  this.transcId = transcId;
 }

 public void setMerchantId(UUID merchantId) {
  this.merchantId = merchantId;
 }

 public LocalDateTime getUpdateAt() {
  return updateAt;
 }

 public int getTranscId() {
 return transcId;
 }

 public UUID getUserId() {
  return userId;
 }

 public UUID getMerchantId() {
  return merchantId;
 }

 public UUID getClientReferenceId() {
  return clientReferenceId;
 }

 public void setCreateAt(LocalDateTime createAt) {
  this.createAt = createAt;
 }

 public LocalDateTime getCreateAt() {
  return createAt;
 }

 public void setUpdateAt(LocalDateTime updateAt) {
  this.updateAt = updateAt;
 }

 public void setUserId(UUID userId) {
  this.userId = userId;
 }

 public void setClientReferenceId(UUID clientReferenceId) {
  this.clientReferenceId = clientReferenceId;
 }

 public double getAmount() {
  return amount;
 }

 public void setAmount(double amount) {
  this.amount = amount;
 }

 public String getCreatedBy() {
  return createdBy;
 }

 public void setCreatedBy(String createdBy) {
  this.createdBy = createdBy;
 }

 public String getUpdateBy() {
  return updateBy;
 }

 public void setUpdateBy(String updateBy) {
  this.updateBy = updateBy;
 }
}
