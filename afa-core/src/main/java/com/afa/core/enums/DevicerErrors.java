package com.afa.core.enums;

import lombok.Getter;

@Getter
@SuppressWarnings("PMD.ExcessivePublicCount")
public enum DevicerErrors {
    UNKNOWN_ERROR("Неизвестная ошибка"),
    UNKNOWN_ILLEGAL_ARGUMENT_ERROR("Ошибка привидения типов"),
    UNKNOWN_VALIDATION_ERROR("Неизвестная ошибка валидации. {0}"),
    DB_FIELD_SORT_NOT_FOUND("Поле, указанное в сортировке <{0}> не существует"),
    DB_FIELD_ASC_DESC_SORT_NOT_FOUND("Направление сортировки <{0}> не существует. Выбирайте два варианта: asc|desc"),
    DB_FIELD_VALUE_NULL("Значение поля <{0}.{1}> не может быть равно null"),
    DB_FIELD_VALUE_NOT_NULL("Значение поля <{0}.{1}> для новой сущности должно быть равно null, но в запросе пришло значение <{2}>"),
    DB_FIELD_VALUE_NOT_UNIQUE("Значение поля <{0}.{1}> неуникально <{2}>"),
    DB_FIELD_VALUE_SLAVE_DIFFERENT_MASTER("Значение поля <{0}.{1}> в дочерней сущности <{2}> не совпадает со значением в родительской сущности <{3}>"),
    DB_FIELD_VALUE_NOT_NUMBER("Значение поля <{0}.{1}> не число <{2}>"),
    DB_ENTITY_NOT_FOUND("Сущность <{0}> с ключом <{1}> не найдена в БД"),
    KEYCLOAK_UUID_EMPTY("Keycloak UUID пуст"),
    KEYCLOAK_UUID_EXISTS_ALREADY("Keycloak UUID <{0}> уже существует"),
    KEYCLOAK_UUID_UNKNOWN("Keycloak UUID <{0}> не найден в БД"),
    KEYCLOAK_PRINCIPAL_IS_NULL("Keycloak принципал равен null"),
    KEYCLOAK_PRINCIPAL_INVALID("Keycloak принципал имеет некорректное значение <{0}>"),

    WRONG_USER("Пользователь сервиса с Keycloak UUID <{0}> не найден в БД"),
    USER_IS_DEACTIVATED("Пользователь <{0}> деактивирован, доступ запрещен"),
    USER_MUST_BE_EMPLOYEE("Пользователь должен быть сотрудником компании для данной операции"),
    USER_EMPLOYEE_INVALID("Для данного сотрудника операция запрещена"),

    PERSON_CONTACT_PHONE_IS_INVALID("Значение номера телефона введено некорректно: <{0}>"),
    PERSON_CONTACT_EMAIL_IS_INVALID("Значение email введено некорректно: <{0}>"),

    // customer
    CUSTOMER_COMPANY_TYPE_FORBIDDEN("Тип клиента требует ввода данных по компании <{0}>"),
    CUSTOMER_COMPANY_TYPE_MUST_NULL("Тип клиента требует отсутствия ввода данных по компании <{0}>"),
    CUSTOMER_COMPANY_BY_INN_EXIST("Компания с таким ИНН уже существует <{0}>"),

    CUSTOMER_PERSON_TYPE_FORBIDDEN("Тип клиента требует ввода данных по персоне <{0}>"),
    CUSTOMER_PERSON_TYPE_MUST_NULL("Тип клиента требует отсутствия ввода данных по персоне <{0}>"),
    CUSTOMER_PERSON_BY_PHONE_EXIST("Покупатель с таким номером телефона уже существует <{0}>"),

    CUSTOMER_CONTACT_NOT_FOUND("У покупателя не указаны контактные данные"),

    // order
    ORDER_PERIOD_NOT_EXIST("Установлен признак \"задан период\" - необходимо задать диапазон дат (с, по)"),
    ORDER_NUM_DUPLICATE("Заказ с таким номером уже существует {0}"),
    ORDER_DELIVERY_RECIPIENT_NOT_FOUND("Получатель заказа не определен <{0}>"),
    ORDER_DELIVERY_CALCULATE_CDEK_ECONOMY_NOT_EXIST("Нет эконом доставки для данного направления"),
    ORDER_DELIVERY_CALCULATE_ERROR("Ошибка расчета доставки"),

    // cdek
    INTEGRATION_CDEK_AUTHORIZATION_ERRORS("Ошибка авторизации в сервис СДЕК: {0}"),
    INTEGRATION_CDEK_CITIES_ERRORS("Ошибка получения городов из сервиса СДЕК: {0}"),
    INTEGRATION_CDEK_DELIVERY_POINTS_ERRORS("Ошибка получения пунктов выдачи из сервиса СДЕК: {0}"),
    INTEGRATION_CDEK_CALC_TARIFF_ERRORS("Ошибка расчета тарифа из сервиса СДЕК: {0}"),

    // sititek
    INTEGRATION_SUPPLIER_SITITEK_FEED_DOWNLOAD_ERRORS("Ошибка загрузки фида из файла СИТИТЕК pricer.xls: {0}"),

    // geonames
    INTEGRATION_GEONAMES_CONNECTION_ERRORS("Ошибка подключения к сервису api.geonames.org"),

    // yandex
    INTEGRATION_YANDEX_GEOCODE_MAPS_CONNECTION_ERRORS("Ошибка подключения к сервису geocode-maps.yandex.ru"),

    // s3
    S3_ERROR("Сервис S3, {0}, ошибка {1}")
    ;

    private final String errorMessage;

    DevicerErrors(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getCode() {
        return name();
    }
}
