import React, { useState, useEffect } from 'react';
import axios, { AxiosResponse } from 'axios';

interface InventoryProduct {
	id: number;
	name: string;
	description: string;
	stock: number;
}

const InventoryTable: React.FC = () => {
	/* Creation of the states. */
	const [inventory, setInventory] = useState<InventoryProduct[]>([]);

	useEffect(() => {
		const checkInventory = async () => {
			const result: AxiosResponse = await axios('http://localhost:8080/inventory');
			setInventory(result.data);
		};
		checkInventory();
	}, []);
	return (
		<section className='inventoryTable w-screen'>
			<h1 className='text-center text-2xl my-4'>Inventory</h1>
			<table className='grid grid-flow-row grid-cols-3 gap-2 cursor-default'>
				<thead className='col-span-3 text-xl'>
					<tr className=''>
						<td className='col-span-1'>Name</td>
						<td className='col-span-1'>Description</td>
						<td className='col-span-1'>Stock</td>
					</tr>
				</thead>
				<tbody className='col-span-3'>
					{inventory
						.filter((product: InventoryProduct) => product.name)
						.map((product: InventoryProduct, index: number) => (
							<tr key={product.id} className={`product-${index}`}>
								<td>{product.name}</td>
								<td>{product.description}</td>
								<td>{product.stock}</td>
							</tr>
						))}
				</tbody>
			</table>
		</section>
	);
};
export default InventoryTable;
