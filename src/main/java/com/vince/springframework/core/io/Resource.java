package com.vince.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author vinceshu
 * @data 2023/2/13 23:14
 * @description
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
