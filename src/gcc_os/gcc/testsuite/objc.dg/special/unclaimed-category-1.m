/* Contributed by Nicola Pero - Fri Dec 14 08:36:00 GMT 2001 */
/* { dg-do run } */
#include <objc/objc.h>
#include <objc/objc-api.h>
#include <objc/Object.h>

/* Test loading unclaimed categories - categories of a class defined
   separately from the class itself.  */


/* unclaimed-category-1.m contains only the class definition but not
   the categories.  unclaimed-category-1a.m contains only the
   categories of the class, but not the class itself.  We want to
   check that the runtime can load the class from one module (file)
   and the categories from another module (file).  */

#include "unclaimed-category-1.h"

@implementation TestClass
- (int)D
{
  return 4;
}
/* APPLE LOCAL begin objc test suite */
#ifdef __NEXT_RUNTIME__                                   
+ initialize { return self; }
#endif
/* APPLE LOCAL end objc test suite */
@end


int main (void)
{
  TestClass *test;
  Class testClass;

  testClass = objc_get_class ("TestClass");
  if (testClass == Nil)
    {
      abort ();
    }
  
  test = (TestClass *)(class_create_instance (testClass));
  if (test == nil)
    {
      abort ();
    }
  
  if ([test A] != 1)
    {
      abort ();
    }
  
  if ([test B] != 2)
    {
      abort ();
    }

  if ([test C] != 3)
    {
      abort ();
    }
  

  if ([test D] != 4)
    {
      abort ();
    }

  return 0;
}
