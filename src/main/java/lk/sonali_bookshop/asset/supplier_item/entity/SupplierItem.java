package lk.sonali_bookshop.asset.supplier_item.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.sonali_bookshop.asset.item.entity.Item;
import lk.sonali_bookshop.asset.supplier.entity.Supplier;
import lk.sonali_bookshop.asset.supplier_item.entity.enums.ItemSupplierStatus;
import lk.sonali_bookshop.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "SupplierItem" )
public class SupplierItem extends AuditEntity {

  @Column( precision = 10, scale = 2 )
  private BigDecimal price;

  @Enumerated( EnumType.STRING )
  private ItemSupplierStatus itemSupplierStatus;

  @ManyToOne( cascade = CascadeType.MERGE )
  private Item item;

  @ManyToOne( cascade = CascadeType.ALL )
  private Supplier supplier;

}
