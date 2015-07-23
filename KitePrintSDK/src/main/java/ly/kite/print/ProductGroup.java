/*****************************************************
 *
 * ProductGroup.java
 *
 *
 * Modified MIT License
 *
 * Copyright (c) 2010-2015 Kite Tech Ltd. https://www.kite.ly
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The software MAY ONLY be used with the Kite Tech Ltd platform and MAY NOT be modified
 * to be used with any competitor platforms. This means the software MAY NOT be modified 
 * to place orders with any competitors to Kite Tech Ltd, all orders MUST go through the
 * Kite Tech Ltd platform servers. 
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 *****************************************************/

///// Package Declaration /////

package ly.kite.print;


///// Import(s) /////


///// Class Declaration /////

import android.os.Parcel;
import android.os.Parcelable;

import java.net.URL;
import java.util.ArrayList;

import ly.kite.product.IGroupOrProduct;

/*****************************************************
 *
 * This class represents a product group.
 *
 *****************************************************/
public class ProductGroup implements Parcelable, IGroupOrProduct
  {
  ////////// Static Constant(s) //////////

  @SuppressWarnings( "unused" )
  private static final String  LOG_TAG = "ProductGroup";


  ////////// Static Variable(s) //////////

  public static final Parcelable.Creator<ProductGroup> CREATOR =
    new Parcelable.Creator<ProductGroup>()
      {
      public ProductGroup createFromParcel( Parcel sourceParcel )
        {
        return ( new ProductGroup( sourceParcel ) );
        }

      public ProductGroup[] newArray( int size )
        {
        return ( new ProductGroup[ size ] );
        }
      };


  ////////// Member Variable(s) //////////

  private String              mLabel;
  private int                 mLabelColour;
  private URL                 mImageURL;

  private ArrayList<Product>  mProductList;


  ////////// Static Initialiser(s) //////////


  ////////// Static Method(s) //////////

  /*****************************************************
   *
   * Returns a list of products within the group specified
   * by the product group label.
   *
   *****************************************************/
  public static ArrayList<Product> findProductsByGroupLabel( ArrayList<ProductGroup> productGroupList, String groupLabel )
    {
    for ( ProductGroup productGroup : productGroupList )
      {
      if ( productGroup.getDisplayLabel().equals( groupLabel ) ) return ( productGroup.getProductList() );
      }

    return ( null );
    }


  ////////// Constructor(s) //////////

  ProductGroup( String label, int labelColour, URL imageURL )
    {
    mLabel       = label;
    mLabelColour = labelColour;
    mImageURL    = imageURL;

    mProductList = new ArrayList<>();
    }


  // Constructor used by parcelable interface
  private ProductGroup( Parcel sourceParcel )
    {
    mLabel       = sourceParcel.readString();
    mLabelColour = sourceParcel.readInt();
    mImageURL    = (URL)sourceParcel.readSerializable();

    mProductList = new ArrayList<>();
    sourceParcel.readTypedList( mProductList, Product.CREATOR );
    }


  ////////// Parcelable Method(s) //////////

  /*****************************************************
   *
   * Describes the contents of this parcelable.
   *
   *****************************************************/
  @Override
  public int describeContents()
    {
    return ( 0 );
    }


  /*****************************************************
   *
   * Write the contents of this product to a parcel.
   *
   *****************************************************/
  @Override
  public void writeToParcel( Parcel targetParcel, int flags )
    {
    targetParcel.writeString( mLabel );
    targetParcel.writeInt( mLabelColour );
    targetParcel.writeSerializable( mImageURL );
    targetParcel.writeTypedList( mProductList );
    }


  ////////// IGroupOrProduct Method(s) //////////

  /*****************************************************
   *
   * Returns the display image URL.
   *
   *****************************************************/
  @Override
  public URL getDisplayImageURL()
    {
    return ( mImageURL );
    }


  /*****************************************************
   *
   * Returns the display label.
   *
   *****************************************************/
  @Override
  public String getDisplayLabel()
    {
    return ( mLabel );
    }


  /*****************************************************
   *
   * Returns the display label colour.
   *
   *****************************************************/
  @Override
  public int getDisplayLabelColour()
    {
    return ( mLabelColour );
    }


  ////////// Method(s) //////////

  /*****************************************************
   *
   * Adds a product to this group.
   *
   *****************************************************/
  void add( Product product )
    {
    mProductList.add( product );
    }


  /*****************************************************
   *
   * Returns the product list.
   *
   *****************************************************/
  public ArrayList<Product> getProductList()
    {
    return ( mProductList );
    }


  ////////// Inner Class(es) //////////

  /*****************************************************
   *
   * ...
   *
   *****************************************************/

  }

