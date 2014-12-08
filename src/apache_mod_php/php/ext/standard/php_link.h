/*
   +----------------------------------------------------------------------+
   | PHP version 4.0                                                      |
   +----------------------------------------------------------------------+
   | Copyright (c) 1997, 1998, 1999, 2000 The PHP Group                   |
   +----------------------------------------------------------------------+
   | This source file is subject to version 2.02 of the PHP license,      |
   | that is bundled with this package in the file LICENSE, and is        |
   | available at through the world-wide-web at                           |
   | http://www.php.net/license/2_02.txt.                                 |
   | If you did not receive a copy of the PHP license and are unable to   |
   | obtain it through the world-wide-web, please send a note to          |
   | license@php.net so we can mail you a copy immediately.               |
   +----------------------------------------------------------------------+
   | Authors:                                                             |
   +----------------------------------------------------------------------+
*/

/* $Id: php_link.h,v 1.1.1.2 2000/09/07 00:06:09 wsanchez Exp $ */

#ifndef PHP_LINK_H
#define PHP_LINK_H

#ifdef HAVE_SYMLINK

PHP_FUNCTION(link);
PHP_FUNCTION(readlink);
PHP_FUNCTION(linkinfo);
PHP_FUNCTION(symlink);

#endif

#endif /* PHP_LINK_H */
