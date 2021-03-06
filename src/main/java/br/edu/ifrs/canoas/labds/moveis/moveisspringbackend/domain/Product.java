package br.edu.ifrs.canoas.labds.moveis.moveisspringbackend.domain;

import br.edu.ifrs.canoas.labds.moveis.moveisspringbackend.domain.enumeration.ProductEnvironment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produto")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Product implements BaseEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "produto_id_seq", allocationSize = 1)
    @Column(name = "id_produto")
    private long id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "valor", nullable = false)
    private Double value;

    @Column(name = "descricao", nullable = true)
    private String description;

    @Column(name = "estoque", nullable = false)
    private Integer stock = 0;

    @Column(name = "fabricante", nullable = true)
    private String manufacturer;

    @Column(name = "modelo", nullable = true)
    private String model;

    @Column(name = "imagem", nullable = true)
    private String image;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_ambiente", nullable = false)
    private ProductEnvironment environment;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "product")
    private List <StockRequest> stockRequests = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductPurchase> productPurchases = new ArrayList<>();

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "product")
    private List <StockEntry> stockEntries = new ArrayList<>();
}
