package com.afa.core.dto.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Контейнер параметров для метода списания остатков товара с фронта и бэка
 *
 * @author alex4doorow
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result4UpdateProductStock {
    // товар на фронте и бэке (как одиночный, так и комплект)
    private boolean isProductFront;
    private boolean isProductBack;
    // элемент комплекта на фронте и бэке (только для комплекта)
    private boolean isSlaveFront;
    private boolean isSlaveBack;
}
