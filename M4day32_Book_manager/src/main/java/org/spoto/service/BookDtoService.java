package org.spoto.service;

import org.spoto.dto.BooknameDto;
import org.spoto.utils.PageData;
import org.spoto.utils.TableData;

import java.util.List;

public interface BookDtoService {

    //联表查询,书的信息
    TableData <BooknameDto> getBooknamebok(PageData pd);

}
